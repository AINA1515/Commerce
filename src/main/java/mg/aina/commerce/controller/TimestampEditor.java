package mg.aina.commerce.controller;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;

/**
 * Editeur de propriete permettant de lier une valeur de champ date/formulaire
 * (ex: "2026-01-15") vers un {@link java.sql.Timestamp}.
 * Accepte les formats "yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm" et
 * "yyyy-MM-dd HH:mm:ss".
 */
public class TimestampEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.isBlank()) {
            setValue(null);
            return;
        }
        String s = text.trim().replace('T', ' ');
        if (s.length() == 10) {
            s = s + " 00:00:00";
        } else if (s.length() == 16) {
            s = s + ":00";
        }
        setValue(Timestamp.valueOf(s));
    }

    @Override
    public String getAsText() {
        Timestamp value = (Timestamp) getValue();
        return value != null ? value.toString() : "";
    }
}