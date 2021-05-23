package jsonParser.types;

import jsonParser.DataType;

public class NumberType implements DataType {
    @Override
    public Object getData(String json) {

        if(json.charAt(0)=='-'){
            if(json.contains("."))
                return -1 * Double.parseDouble(json.substring(1));
            else
                return -1 * Long.parseLong(json.substring(1));
        }
        else{
            if(json.contains("."))
                return Double.parseDouble(json);
            else
                return -1 * Long.parseLong(json);
        }
    }
}
