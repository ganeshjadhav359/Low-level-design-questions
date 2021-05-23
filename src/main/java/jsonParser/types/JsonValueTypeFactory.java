package jsonParser.types;

public class JsonValueTypeFactory {

    public static Object jsonValueDecider(String  value){

        if("null".equals(value))
            return new NullType().getData(value);
        else if("".equals(value))
            return new StringType().getData(value);
        else if("true".equals(value))
            return Boolean.TRUE;
        else if("false".equals(value))
            return Boolean.FALSE;
        else if(value.matches("-?([0-9]\\d*)(\\.\\d+)?(\\d+)?$"))
            return new NumberType().getData(value);
        else
            return new StringType().getData(value);


    }

}
