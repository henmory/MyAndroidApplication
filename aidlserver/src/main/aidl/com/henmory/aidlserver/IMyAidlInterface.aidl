// IMyAidlInterface.aidl
package com.henmory.aidlserver;
import com.henmory.aidlserver.Person;
// Declare any non-default types here with import statements

interface IMyAidlInterface {
    int add(int a, int b);
    void save(in Person person);
}
