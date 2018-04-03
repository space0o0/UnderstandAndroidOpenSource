// IBookManager.aidl
package com.space.understandandroidopensource.part2_ipc.aidl;

import com.space.understandandroidopensource.part2_ipc.aidl.Book;
// Declare any non-default types here with import statements

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
