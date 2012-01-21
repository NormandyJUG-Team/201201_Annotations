package com.zenika.presentation.annotations.runtime.csvreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Olivier Croisier
 * @version $Id: CSVReader.java 1924 2010-12-14 16:05:55Z OlivierCroisier $
 */
public abstract class CSVReader<T> {

    public static final String DELIMITER = ";";

    private Map<Integer, Field> fieldAccessors = new HashMap<Integer, Field>();

    public CSVReader(Class<T> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            CSVField annotation;
            if ((annotation = field.getAnnotation(CSVField.class)) != null) {
                int position = annotation.position();
                field.setAccessible(true);
                fieldAccessors.put(position, field);
            }
        }
    }

    public List<T> read(Reader reader) throws IOException, NoSuchFieldException {
        List<T> records = new ArrayList<T>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(reader);

            String line;
            while ((line = br.readLine()) != null) {

                T container = newContainer();

                String[] csvFields = line.split(DELIMITER);
                for (int i = 0; i < csvFields.length; i++) {

                    Field field = fieldAccessors.get(i + 1);
                    if (field != null) {
                        try {
                            field.set(container, csvFields[i]);
                        } catch (IllegalAccessException e) {
                            throw new NoSuchFieldException(field.getName());
                        }
                    }

                }
                records.add(container);

            }
        } finally {
            if (br != null) {
                br.close();
            }
        }

        return records;
    }

    protected abstract T newContainer();

}
