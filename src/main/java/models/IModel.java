package models;

import java.beans.PropertyChangeListener;

public interface IModel {
    void addListener(PropertyChangeListener listener);
}
