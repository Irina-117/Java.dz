package com.geekbrains.Fam_tree.FamTree;

import com.geekbrains.Fam_tree.Human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator<T> {
    private int curInd;
    private List<T> familyTree;

    public HumanIterator(List<T> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return familyTree.size() > curInd;
    }

    @Override
    public T next() {
        return familyTree.get(curInd++);
    }


}
