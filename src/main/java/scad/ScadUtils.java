package scad;

import com.google.zxing.common.BitMatrix;
import eu.printingin3d.javascad.context.ColorHandlingContext;
import eu.printingin3d.javascad.coords.Coords3d;
import eu.printingin3d.javascad.coords.Dims3d;
import eu.printingin3d.javascad.models.Abstract3dModel;
import eu.printingin3d.javascad.models.Cube;
import eu.printingin3d.javascad.tranzitions.Union;
import eu.printingin3d.javascad.utils.ModelToFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScadUtils {

    /**
     * @param file                  Input file
     * @param scadOutputPath        Output path for end result SCAD file
     * @param bitMatrix             Input BitMatrix containing boolean values corresponding to white and black pixels
     * @throws IOException          If file does not exist
     * @throws NullPointerException If the supplied BitMatrix is null
     */
    public static void scadFromFile(File file, String scadOutputPath, BitMatrix bitMatrix)
            throws IOException, NullPointerException {
        if (file.exists() && bitMatrix != null) {
            int imgWidth = bitMatrix.getWidth();
            int imgHeight = bitMatrix.getWidth();

            // Set up the output file and a utility to write the models to the output
            File outputStlFile = new File(scadOutputPath);
            ModelToFile outputModelToFile = new ModelToFile(outputStlFile);

            // Generate the base cube (quiet zone etc) and add it to the eventual output.
            Cube qrBaseCube = new Cube(new Dims3d(imgWidth, imgHeight, 1));
            outputModelToFile.addModel(qrBaseCube);
            List<Abstract3dModel> qrDataCubes = new ArrayList<>();

            for (int x = 0; x < bitMatrix.getWidth(); x++) {
                for (int y = 0; y < bitMatrix.getWidth(); y++) {
                    if (bitMatrix.get(x, y)) {
                        Cube dataCube = new Cube(new Dims3d(1, 1, 5));

                        // minus size/2 is used to centre the model on the coordinate plane
                        dataCube = (Cube) dataCube.move(new Coords3d(y - (imgWidth / 2), x - (imgHeight / 2), 3));
                        qrDataCubes.add(dataCube);
                    }
                }
            }

            // Union prevents any unforeseen intersections which may conflict with printing.
            Union union = new Union(qrDataCubes);

            outputModelToFile.addModel(union);
            outputModelToFile.saveToFile(ColorHandlingContext.DEFAULT);
        } else if (!file.exists()) {
            throw new FileNotFoundException("Image not found, please ensure you have selected a valid file.");
        } else if (bitMatrix == null) {
            throw new NullPointerException("An error occurred in generating the QR code. Please try again.");
        }
    }
}
