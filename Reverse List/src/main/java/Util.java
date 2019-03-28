import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Util {

    /**
     * Method reverses the given list but doesn't creates a new list.
     *
     * @param list to be reversed
     * @param <E> any type
     */
    public static <E> void reverse1(List<E> list) {
        Collections.reverse(list);
    }

    /**
     * Method creates a new list which's content is the reversal of the given list.
     *
     * @param list to be reversed
     * @param <E> any type
     * @return new list
     */
    @SuppressWarnings("unchecked")
    public static <E> List<E> reverse2(List<E> list) {
        List<E> result = null;
        try {
            result = list.getClass().newInstance();
        } catch (Exception e){
            result = new ArrayList<E>();
        }

        for(int i = list.size()-1; i >= 0; i--){
            result.add(list.get(i));
        }
        return result;
    }


}
