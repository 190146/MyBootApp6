package jp.te4a.spring.boot.myapp9;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.te4a.spring.boot.myapp9.BookForm;
@Service
public class BookService {
	@Autowired
	public BookForm create(BookForm bookForm) {
		BookBean bookBean = new BookBean();
		BeanUtils.copyProperties(bookForm, bookBean);
		bookRepository.save(bookBean);
		return bookForm;
	}

	public BookForm update(BookForm bookForm) {
		BookBean bookBean = new BookBean();
		BeanUtils.copyProperties(bookForm, bookBean);
		bookRepository.save(bookBean);
		return bookForm;
	}

	public void delete(Integer id) {

		BookBean bean = new BookBean();
		bean.setId(id);
		bookRepository.delete(bean);

	}
	public List<BookForm> findAll() {
		List<BookBean> beanList = bookRepository.findAll();
		List<BookForm> formList = new ArrayList<BookForm>();
		for(BookBean bookBean: beanList) {
			BookForm bookForm = new BookForm();
			BeanUtils.copyProperties(bookBean, bookForm);
			formList.add(bookForm);
		}
		return formList;
	}
	//repositoryのデータを取り出す
	public BookForm findById(Integer id) {			

		//BookForm bookBean = bookRepository.findById(id);
		Optional<BookBean> bookBean = bookRepository.findById(id);

		//ラムダ関数
		Optional<BookBean> opt =  bookRepository.findById(id);
		opt.ifPresent(book -> {
			// bookを使った処理
		});

		BookForm bookForm = new BookForm();
		BeanUtils.copyProperties(bookBean, bookForm);
		return bookForm;

		/*public BookForm findOne(Integer id) {
		BookBean bookBean = findById(id);
		BookForm bookForm = new BookForm();
		BeanUtils.copyProperties(bookBean, bookForm);
		return bookForm;
	}*/
	}
}
