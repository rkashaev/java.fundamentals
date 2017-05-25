package courses.tasks;

import java.util.HashMap;
        import java.util.Map;
        import java.util.Stack;

public class Brackets {

    public static boolean check(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> braceMap = new HashMap<>();
        braceMap.put('[', ']');
        braceMap.put('{', '}');
        braceMap.put('(', ')');

        for (int i = 0; i < s.length(); i++) {
            char cChar = s.charAt(i);
            if (braceMap.containsKey(cChar)) {
                st.push(cChar);
            } else if (braceMap.containsValue(cChar)) {
                if (st.empty()) {
                    return false;
                }
                char c = braceMap.get(st.pop());
                if (c != cChar) {
                    return false;
                }
            }
        }
        return true;
    }
}