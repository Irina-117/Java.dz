package com.geekbrains.Fam_tree.Human;

import com.geekbrains.Fam_tree.FamTree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComporatorByAge<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
    }
}
