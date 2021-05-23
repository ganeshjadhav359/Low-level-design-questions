package jsonParser.types;

import java.util.HashMap;
import java.util.Map;

import static jsonParser.types.JsonValueTypeFactory.jsonValueDecider;

public class JsonObject {
    Map<String ,Object> map= new HashMap<>();

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }


    public JsonObject(JsonToken json) throws Exception{
        char ch = json.getNextChar();
        if(ch!='{'){
            throw  new Exception("object must start with {");
        }
        else{
            while(true){
                char type = json.getNextChar();
                if(type=='}')
                    return;

                json.oneCharBack();
                String key = json.getKey();

                if (type == '{') {
                        json.oneCharBack();
                        map.put(key, new JsonObject(json));
                    } else if (type == '[') {
                        map.put(key, new JsonArray(json));
                    }
                    String value = json.getValue();
                    Object jsonValue = jsonValueDecider(value);
                    map.put(key, jsonValue);
            }
        }
    }

    public JsonObject(String json) throws Exception {
        this(new JsonToken(json));
    }

}
