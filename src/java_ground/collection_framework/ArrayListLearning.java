package java_ground.collection_framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListLearning {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
            list.add("Hello");
            list.add("World");
            list.add("Java");
            list.add("ArrayList");

            // Fail-Fast Behavior Example
//           for (String s : list) {  // This will throw ConcurrentModificationException because we are modifying the list while iterating over it
//               if (s.contains("Hello")) {
//                   list.remove(s);
//               }
//           }
//        System.out.println(list);
//
         // Fail-Fast Behavior Example (Correct way to remove while iterating)
//        NOTE : To avoid this, we can use an iterator or a synchronized list or a CopyOnWriteArrayList depending on the use case.
          Iterator<String> iterator = list.iterator();
          if (iterator.hasNext()) {
               if(iterator.next().equals("Hello")) {
                   iterator.remove();
               }
                 // This is the correct way to remove an element while iterating
          }

//        Iterator<String> iterator = list.iterator();
//        if (iterator.hasNext()) {
//               if(iterator.next().equals("Hello")) {
//                   list.remove("Hello"); // This will still throw ConcurrentModificationException because we are modifying the list directly instead of using the iterator's remove method
//               }
//
//          }
        System.out.println(list);

        // SYNCHRONIZATION  EXAMPLE

        List<String> activeUsers =
            Collections.synchronizedList(new ArrayList<>()); // Create a synchronized list to handle concurrent modifications

        // User Login Thread
        Runnable loginTask = () -> {
            for (int i = 0; i < 100; i++) {
                activeUsers.add("User-" + i); // internal synchronization is handled by synchronizedList, so we can safely add users without additional synchronization
            }
        };

        // User Logout Thread
        Runnable logoutTask = () -> {
            for (int i = 0; i < 50; i++) {
                if (!activeUsers.isEmpty()) { // internal synchronization is handled by synchronizedList, so we can safely check and remove users without additional synchronization
                    activeUsers.remove(0); // internal synchronization is handled by synchronizedList, so we can safely remove users without additional synchronization
                }
            }
        };

        Thread t1 = new Thread(loginTask);
        Thread t2 = new Thread(logoutTask);

        t1.start(); // Start login thread
        t2.start(); // Start logout thread

        t1.join(); // Wait for login thread to finish
        t2.join(); // Wait for logout thread to finish

        // Safe iteration (must synchronize)
        synchronized (activeUsers) { // Synchronize on the list before iterating
            System.out.println("Active Users:");
            for (String user : activeUsers) {
                System.out.println(user);
            }
        }

        // COPY ON WRITE EXAMPLE

        List<String> configRules =
            new CopyOnWriteArrayList<>(); // Create a CopyOnWriteArrayList for infrequent updates and many reads

       // On every write (add/remove), it creates a new copy of the array
        // Load config at startup
        configRules.add("ALLOW_LOGIN");
        configRules.add("ENABLE_CACHE");
        configRules.add("MAX_USERS=100");

        // Many threads reading config
        Runnable readTask = () -> {
            for (String rule : configRules) {
                System.out.println(Thread.currentThread().getName()
                    + " reads: " + rule);
            }
        };

        // Rare update (Admin changes config)
        Runnable updateTask = () -> {
            configRules.add("ENABLE_AUDIT_LOG");
            System.out.println("Config Updated");
        };

        Thread t5 = new Thread(updateTask);
        Thread t3 = new Thread(readTask, "Reader-1");
        Thread t4 = new Thread(readTask, "Reader-2");

        t5.start();
        t3.start();
        t4.start();


        System.out.println(configRules);
    }

}
