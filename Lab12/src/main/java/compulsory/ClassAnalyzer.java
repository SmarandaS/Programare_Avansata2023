package compulsory;



import java.io.FileInputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassAnalyzer {

    public static void main(String[] args) {


        String classFilePath = "C:\\Users\\smara_9yjfm5z\\IdeaProjects\\LAB12\\src\\clase\\Analizeaza.class";
        try {
            // Load class given by path
            FileInputStream fileInputStream = new FileInputStream(classFilePath);
            byte[] classBytes = new byte[fileInputStream.available()];  //array de bytes nou de dim nr de bytes pe care ii pot citi din input
            fileInputStream.read(classBytes);  //return nr de bytes cititi
            fileInputStream.close();

            Class<?> loadedClass = new CustomClassLoader().defineClass(classBytes);

            // Class info (nume, pachet)
            String className = loadedClass.getName();
            String packageName = loadedClass.getPackage().getName();
            System.out.println("Loaded class: " + className);
            System.out.println("Package: " + packageName);

            Method[] methods = loadedClass.getDeclaredMethods();

            List<Method> testMethods = new ArrayList<>();
            List<Method> otherMethods = new ArrayList<>();

            // Metodele de test sunt cele cu init iar celelalte merg in other methods
            for (Method method : methods) {
                if (method.isAnnotationPresent(Init.class) && method.getParameterCount() == 0
                        && method.getReturnType() == void.class) {
                    testMethods.add(method);
                }
                else {
                    otherMethods.add(method);
                }
            }


            //afisez metodele de test iar pentru celelalte le chem cu parametru null
            for (Method method : testMethods) {
                System.out.println("Test methods: " + method.getName());
                //method.invoke(null);
            }
            for (Method method : otherMethods) {
                System.out.println("Other methods: " + method.getName());
                method.invoke(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

