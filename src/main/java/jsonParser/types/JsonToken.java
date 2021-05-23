package jsonParser.types;

public class JsonToken{

    String json ;
    int length;
    int next;


    public JsonToken() {
    }

    public JsonToken(String json) {
        this.json = json;
        this.length = json.length();
        this.next = 0;
    }

    public char getNextChar(){
        if(next>=length)
                return '\u0000';
        else
            return json.charAt(next++);
    }


    public String getKey() {
        StringBuilder sb = new StringBuilder();
        next++;
        while (json.charAt(next)!='"'){
            sb.append(json.charAt(next++));
        }
        next++;
        return sb.toString();
    }

    public void oneCharBack() {
        next--;
    }

    public String getValue() {
        StringBuilder sb = new StringBuilder();
        next++;
        while (json.charAt(next)!='"'){
            sb.append(json.charAt(next++));
        }
        next++;
        return sb.toString();
    }
}
