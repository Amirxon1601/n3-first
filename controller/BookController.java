package uz.nt.firstspring.controller;

import org.springframework.web.bind.annotation.*;
import uz.nt.firstspring.dto.BookDto;
import uz.nt.firstspring.dto.ResponseDto;
import uz.nt.firstspring.model.Book;
import uz.nt.firstspring.dto.BookDto;
import uz.nt.firstspring.model.Book;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Book")
public class BookController {
    private List<Book> books = new ArrayList<>();

    @GetMapping
        public BookDto getById(@RequestParam Integer id){
        books.add(new Book(1, "Halol luqma", 50000D));
        books.add(new Book(1, "Piyoz nega xomush", 40000D));
        books.add(new Book(1, "Zamonani eng zo`r dasturchilari", 30000D));

        for (Book book : books){
            if(book.getId() == id){
                return new BookDto(book.getId(), book.getName(), book.getPrice());
            }
        }
        return null;
    }

    @PatchMapping
        public ResponseDto updateBook(@RequestBody BookDto bookDto) {
            for (Book b : books) {
                if (b.getId().equals(bookDto.getId())) {
                    if (bookDto.getName() != null) b.setName(bookDto.getName());
                    if ((bookDto.getPrice() != null)) b.setPrice(bookDto.getPrice());

                    return ResponseDto.builder().code(1).success(true).message("Successfully updated").build();
                }
            }
            return ResponseDto.builder().code(-1).success(false).message("Not Found").build();
        }
}
