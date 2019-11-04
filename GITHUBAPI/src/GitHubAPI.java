
import java.io.IOException;
import java.text.MessageFormat;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.RepositoryService;

public class GitHubAPI 
{
	public static void main(String[] args) throws IOException 
	{

		final String user = "defunkt";
		final String name = "defunkt";

		final String format = "{0}) {1}- created on {2}";

		int count = 1;

		RepositoryService service = new RepositoryService();
		
		service.getRepository(user, name);
		
//		for(Repository repo : service.getRepositories(user))
		for(Repository repo : service.getRepositories(user, name))
		{
			System.out.println(MessageFormat.format(format, count++, repo.getName(), repo.getCreatedAt()));
		}
	}
}