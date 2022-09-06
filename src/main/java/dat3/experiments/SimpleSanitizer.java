package dat3.experiments;

//Never use anything in here for real
public class SimpleSanitizer {
    public static String simpleSanitize(String s){

        String[] htmlTags = {"<h1>", "</h1>", "<div>", "</div>", "<b>", "</b>"};

        for (String tag: htmlTags) {
            if(s.contains(tag)){
                String replacement = "";
                s = s.replace(tag, replacement);
            }
        }
        //throw new UnsupportedOperationException("Not implemented yet");
        return s;
    }


    //Lav en testklasse for ovenstående klasse og tilføj denne test til klassen



    public static void main(String[] args) {
        String toTest = "Hello <b>World</b>";
        String result = simpleSanitize(toTest);
        System.out.println(result);
    }

}
