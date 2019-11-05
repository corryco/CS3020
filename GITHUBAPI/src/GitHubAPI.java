
import java.io.IOException;
import java.net.URL; 

import org.eclipse.egit.github.core.Repository; 
import org.eclipse.egit.github.core.RepositoryId; 
import org.eclipse.egit.github.core.User; 
import org.eclipse.egit.github.core.service.RepositoryService; 
import org.eclipse.egit.github.core.client.GitHubClient; 

import org.eclipse.egit.github.core.Comment;
import org.eclipse.egit.github.core.Gist;
import org.eclipse.egit.github.core.GistFile;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Label;
import org.eclipse.egit.github.core.Milestone;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.client.GitHubRequest;
import org.eclipse.egit.github.core.client.GitHubResponse;
import org.eclipse.egit.github.core.client.PageIterator;
import org.eclipse.egit.github.core.client.PagedRequest;
import org.eclipse.egit.github.core.service.CollaboratorService;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.GistService;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.egit.github.core.service.LabelService;
import org.eclipse.egit.github.core.service.MarkdownService;
import org.eclipse.egit.github.core.service.MilestoneService;
import org.eclipse.egit.github.core.service.UserService;

public class GitHubAPI 
{
	
	public static void main(String[] args) throws IOException 
	{
		
		String username = "corryco";
		String password ="Uaz9401CC";
		
		GitHubClient client = null; 

		client = new GitHubClient();
		client.setCredentials(username, password);
		
		String url = "https://github.com/corryco/CS3020.git";

		RepositoryService repoService  = new RepositoryService(client); 
		UserService serService = new UserService(client);
		IssueService issueService = new IssueService(client);
		MilestoneService milestoneService = new MilestoneService(client);
		LabelService labelService = new LabelService(client);
		CommitService commitService = new CommitService(client);
		MarkdownService markdownService = new MarkdownService(client);
		CollaboratorService colaboratorService = new CollaboratorService(client);
		ContentsService contentsService = new ContentsService(client);
		
		/*		
		GitHubClient client = null; 
		//String url = ("github.test.url");
		String url = "https://github.com/corryco/CS3020.git";

		if (url != null) 
		{ 
				URL parsed = new URL(url); 
				client = new GitHubClient(parsed.getHost(), parsed.getPort(), 
				parsed.getProtocol()); 
		} 
		else 
			client = new GitHubClient(); 
		
		String user;
		String password;
		String writableRepo;
		 	 
		 user = System.getProperty("github.test.user"); 
		 password = System.getProperty("github.test.password"); 
		 writableRepo = System.getProperty("github.test.repository"); 

		 client.setCredentials(user, password);
*/
	}
}