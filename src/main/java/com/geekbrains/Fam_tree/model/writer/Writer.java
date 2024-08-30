package com.geekbrains.Fam_tree.model.writer;

import java.io.Serializable;

public interface Writer {
boolean save(Serializable obj);
Object read();
void setPath (String path);
}
