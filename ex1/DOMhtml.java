package Liste_chainée;

import java.util.Arrays;
import java.util.Collections;

public class html{

    public static void main(String[] args) {
    


    	NaryTree<String> titleContent = new NaryTree<>("Page test");
    	NaryTree<String> title = new NaryTree<>("title", Collections.singletonList(titleContent));

    
    	NaryTree<String> head = new NaryTree<>("head", Collections.singletonList(title));

   
    	NaryTree<String> h1Content = new NaryTree<>("Titre niveau 1");
    	NaryTree<String> h1 = new NaryTree<>("h1", Collections.singletonList(h1Content));

    	NaryTree<String> pContent = new NaryTree<>("Saluttt");
    	NaryTree<String> p = new NaryTree<>("p", Collections.singletonList(pContent));


    	NaryTree<String> body = new NaryTree<>("body", Arrays.asList(h1, p));

       
    	NaryTree<String> htmlDOM = new NaryTree<>("html", Arrays.asList(head, body));

       
        System.out.println("DOM HTML :");
        System.out.println(htmlDOM.displayTree());
    }
}
