package jsonParser.types;

import jsonParser.DataType;

import java.util.Map;

public class StringType implements DataType {
    @Override
    public Object getData(String json) {
        return json;
    }
}
