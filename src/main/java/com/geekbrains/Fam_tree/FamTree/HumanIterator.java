package com.geekbrains.Fam_tree.FamTree;

import com.geekbrains.Fam_tree.Human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int curInd;
    private List<Human> familyTree;

    public HumanIterator(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return familyTree.size() > curInd;
    }

    @Override
    public Human next() {
        return familyTree.get(curInd++);
    }


}
