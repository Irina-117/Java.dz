package com.geekbrains.Fam_tree.Writer;

import java.io.Serializable;

public interface Writer {
boolean save(Serializable obj);
Object read();
}
