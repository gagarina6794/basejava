package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.MapStorage;
import ru.javawebinar.basejava.storage.Storage;

public class MainTestArrayStorage {

    // static final Storage ARRAY_STORAGE = new ArrayStorage();
    // static final Storage ARRAY_STORAGE = new SortedArrayStorage();
    // static final Storage ARRAY_STORAGE = new ListStorage();
    static final Storage ARRAY_STORAGE = new MapStorage();

    public static void main(String[] args) {

        final Resume resume1 = new Resume("uuid1");
        final Resume resume2 = new Resume("uuid3");
        final Resume resume3 = new Resume("uuid2");
        final Resume resume4 = new Resume("uuid2");

        ARRAY_STORAGE.save(resume1);
        ARRAY_STORAGE.save(resume2);
        ARRAY_STORAGE.save(resume3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(resume1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

//        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.update(resume4);
        printAll();
        ARRAY_STORAGE.delete(resume1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume resume : ARRAY_STORAGE.getAll()) {
            System.out.println(resume);
        }
    }
}
