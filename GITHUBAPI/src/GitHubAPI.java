
import java.io.IOException;

import java.text.MessageFormat;



import org.elipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.RepositoryService;

public class GitHubAPI 
{

	
	ublic static void main(String[] args) throws IOException {

		final String user = "defunkt";

		final String format = "{0}) {1}- created on {2}";

		int count = 1;

		RepositoryService service = new RepositoryService();

		for (Repository repo : service.getRepositories(user))


			
			System.out.println(MessageFormat.format(format, count++,

					repo.getName(), repo.getCreatedAt()));

	}
}
