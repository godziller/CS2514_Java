# Program 1

```mermaid
graph TD
    A[Start] --> B[Create Scanner object for user input]
    B --> C[Loop 10 times to get 10 names]

    subgraph InputLoop[Input Loop]
        C1[Ask for name input]
        C2[Store name in ArrayList]
        C3[Repeat for next name]

        C1 --> C2
        C2 --> C3
        C3 --> C1
    end

    C --> InputLoop
    InputLoop --> D[Close the scanner]
    D --> E[Call bubbleSort to sort names]

subgraph BubbleSort[Bubble Sort Algorithm]
F1[Outer loop: Pass through the list n-1 times]
F2[Inner loop: Compare adjacent names]
F3[If names are out of order, swap them]
F4[Repeat the inner loop until sorted]

F1 --> F2
F2 --> F3
F3 --> F4
F4 --> F2
F4 --> F1
end

E --> BubbleSort
BubbleSort --> L[End of sorting, print sorted names]
L --> M[Display sorted names]
M --> N[End]
```

```java
import java.util.*;
public class OrderNames{
    public static void main(String[] args){
        // make list buffer
        ArrayList<String> names = new ArrayList<>();

        // Create Scanenr Object
        Scanner scanner = new Scanner(System.in);

        // Make a loop of 10, ask for name -> store in list buffer
        for (int i = 1; i <= 10; i++){
            System.out.print("Please enter a name: ");
            String name = scanner.nextLine();
            names.add(name);	// Appending to array.
        }

        scanner.close();

        // Sort list of names -> Alphabetically
        //Collections.sort(names);
        bubbleSort(names);

        System.out.println("Sorted names: ");
        // Iterate over names and print
        for (String name : names){
            System.out.println(name);
        }
    }

    // Instead of using Collections.sort I'm going to try and
    // create my own sort algo here as recommended by question.
    // So bubblesort seems a good idea from CS2516:Algorithms and Data Structures

    public static void bubbleSort(ArrayList<String> names) {
        int n = names.size();
        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent strings
                // This should handle Adrian vs Aidan scenarios..
                if (names.get(j).compareTo(names.get(j + 1)) > 0) {
                    // Swap if elements are in the wrong order
                    String temp = names.get(j);
                    names.set(j, names.get(j + 1));
                    names.set(j + 1, temp);
                }
            }
        }
    }
}

```