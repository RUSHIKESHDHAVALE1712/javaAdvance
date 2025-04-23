package Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

import com.museum.entity.Article;
import com.museum.entity.ArticleDao;
import com.museum.entity.Category;

public class ArticleService {

	private ArticleDao articleDao;
	
	public ArticleService() throws SQLException
	{
		articleDao = new ArticleDao();
	}
		
	public void addArticle(String name,Category category,LocalDate createdDate,String creatorname)throws SQLException, ResourceAlreadyExistException
	{
		Optional<Article> existingArticle =  articleDao.findAll().stream().filter(article -> article.getName().equalsIgnoreCase(name)).findFirst();
	
		if(existingArticle.isEmpty())
		{
			Article newArticle = new Article(null, name, category, createdDate, creatorname);
			boolean status = articleDao.save(newArticle);
			if(status)
			{
				System.out.println("Article Added Successfully...!!!");
			}
			else
			{
				throw new ResourceAlreadyExistException("Article Is Already Exist"+name);
			}
		}
			
	}
		public void displayAllArticles() throws SQLException
		{
			articleDao.findAll().stream().forEach(article -> System.out.println(article));
		}
		
		public void displayArticleDetails(Integer id) throws SQLException, ResourceNotFoundArticle
		{
			Article foundArticle = articleDao.findById(id);
			if(foundArticle != null)
			{
				System.out.println(foundArticle);
			}
			else {
				throw new ResourceNotFoundArticle("Article not found of id: "+id);
			}
		}
		
	
		
		

	

}
