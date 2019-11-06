
import java.io.IOException;
import java.net.URL; 
import java.util.List; 

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
import org.eclipse.egit.github.core.Key; 
import org.eclipse.egit.github.core.service.UserService; 
import org.eclipse.egit.github.core.User; 

public class GitHubAPI 
{
	
	public static void main(String[] args) throws IOException 
	{
		
		String username = "corryco";
		String password ="Uaz9401CC";
		
		GitHubClient client = null; 

		client = new GitHubClient();
		client.setCredentials(username, password);
		
		RepositoryService repoService  = new RepositoryService(client); 
		UserService serService = new UserService(client);
		IssueService issueService = new IssueService(client);
		MilestoneService milestoneService = new MilestoneService(client);
		LabelService labelService = new LabelService(client);
		CommitService commitService = new CommitService(client);
		MarkdownService markdownService = new MarkdownService(client);
		CollaboratorService colaboratorService = new CollaboratorService(client);
		ContentsService contentsService = new ContentsService(client);
		
		
		UserService service = new UserService(client); 
		List<User> users = service.getFollowing(); 
		  for (User user : users) 
		  { 
		   int iUserDI = user.getId();
		   String strLoginId = user.getLogin(); 
		  } 
		
		
	}
}