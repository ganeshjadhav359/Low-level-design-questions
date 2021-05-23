package jsonParser.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jsonParser.types.JsonValueTypeFactory.jsonValueDecider;

public class JsonArray {

    List<JsonObject > arr = new ArrayList<>();

    public List<JsonObject> getArr() {
        return arr;
    }

    public void setArr(List<JsonObject> arr) {
        this.arr = arr;
    }

    public JsonArray(JsonToken json) throws Exception {

        char ch = json.getNextChar();
        if(ch!='[')
            throw new Exception("json array must start with [");
        else{
            char type = json.getNextChar();

            if(type=='{'){
                json.oneCharBack();
                arr.add(new JsonObject(json));
            }
        }


    }
}
