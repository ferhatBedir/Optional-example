package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        // Optional
        /**
         "of" : Bu method Optional türde olmayan herhangi bir nesneyi Optional türe çevirmek için kullanılır.
         Tabiki bu nesneye bir değer atanmış olması gerekmektedir. Eğer NullPointerException almak istiyor isek,
         of methodunun içerisine null değerini vermemiz yeterlidir.
         "ofNullable" : Bu method Optional türde olmayan herhangi bir nesneyi Optional türe çevirmek için kullanılır.
         Adındanda anlaşıldığı üzre atanan değer null olabilir.
         of methodundan ayrı olarak null değeri verdiğimiz zaman NullPointerException değilde NoSuchElementException ile karşılaşırız.*/

        String name = "ferhat";
        Optional<String> nameOptional = Optional.of("ferhat");


        /**
         "get" : Bu method Optional sınıfı içerisinde oluşturulmuş olan T tipindeki nesneye erişmek için kullanırız.*/

        nameOptional.get();
        System.out.println(nameOptional.get());


        /**
         empty : Bu method bize boş bir Optional nesnesi üretmemizi sağlar.
         Tabiki Optional türde bir objenin T tipine erişebilmek için get() methodu kullanılır.
         Empty yani boş oluşturulan bir Optional nesnesini get etmek istersek NoSuchElementException ile karşılaşırız.
         Sebebi nesneye henüz bir değer atanmamış olmasıdır.
         */

        Optional<Integer> optional = Optional.empty();


        /**
         ifPresent : Bu method Optional türde olan bir nesne için eğer tanımlı ise içerisinde işlem yapılmasına izin verir.
         */

        List<String> names = new ArrayList<>();
        names.add("ferhat");
        names.add("ahmet");
        names.add("mehmet");
        names.add("ali");
        Optional<List<String>> namesOptional = Optional.of(names);
        namesOptional.ifPresent(System.out::println);


        /**
         isPresent : Bu method Optional türde olan bir nesnenin tanımlı olup olmadığını kontrol etmemizi sağlar.
         Eğer tanımlı ise true değil ise false değeri döner.
         */

        Optional<String> exampleFalse = Optional.empty();
        Optional<String> exampleTrue = Optional.of("ferhat bedir");
        boolean isTrue = exampleTrue.isPresent();
        System.out.println(isTrue);
        boolean isFalse = exampleFalse.isPresent();
        System.out.println(isFalse);


        /**
         map : Bu method Optional türde tanımlı olan bir nesne üzerinde işlemler yapmamıza olanak sağlar.
         */

        Optional<String> example1 = Optional.of("Ferhat Bedir");
        example1.map(String::length);
        System.out.println(example1.map(String::length));

        List<String> arrayList = new ArrayList<>();
        arrayList.add("Ahmet");
        arrayList.add("Ayşe");
        arrayList.add("Mehmet");
        arrayList.add("Fatma");
        Optional<List<String>> nameList = Optional.of(arrayList);
        nameList.map(List::size).get();
        System.out.println(nameList.map(List::size).get());


        /**
         orElse : Bu method Optional türde oluşturulan nesne tanımlı olup olmasına bakmaksızın verilen değerini döner.
         */
        /**
         orElseGet : orElse methodundan farklı olarak orElse içerisindeki değer Optional’ın empty olup olmasına bakmaksızın direk çalışır.
         orElseGet ise Optional empty ise çalışır.
         */

        Optional<String> example2 = Optional.of("Ferhat Bedir");
        System.out.println(example2.orElse("Ahmet Mehmet"));//yazılacak değer Ahmet Mehmet olması gerekirken Ferhat Bedir yazdığına dikkat edelim.
        System.out.println(example2.orElse(filterTestExampleMethod()));//yazılacak değer Ahmet Mehmet olması gerekirken Ferhat Bedir yazdığına dikkat edelim.


        /**
         Bu method Optional türde tanımlı olan bir nesne üzerinde işlemler yapmamıza olanak sağlar.
         */

        Optional<String> example3 = Optional.of("Ferhat Bedir");
        example3.filter(i -> "Ferhat Bedir".equals(i)).ifPresent(System.out::println);


        /**
         orElseThrow : Bu method Optional türde oluşturulan bir nesne için gerekli durumda exception fırlatır.
         */

        Optional<String> example4 = Optional.empty();
        System.out.println(example4.orElseThrow(IllegalArgumentException::new));

    }

    private static String filterTestExampleMethod() {
        return "Ahmet Mehmet";
    }
}
