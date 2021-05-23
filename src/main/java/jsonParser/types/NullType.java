package jsonParser.types;

import jsonParser.DataType;

import java.util.Map;

public class NullType implements DataType {
    @Override
    public Object getData(String json) {
        return null;
    }
}
