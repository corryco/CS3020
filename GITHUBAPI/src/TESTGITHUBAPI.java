import static org.junit.Assert.*;


import org.junit.Test;

import java.io.IOException; 
import java.util.List; 
//import java.util.Map; 
//import java.util.Map.Entry; 
import java.util.ArrayList; 

import org.eclipse.egit.github.core.Repository; 
import org.eclipse.egit.github.core.RepositoryId; 
import org.eclipse.egit.github.core.User; 
import org.eclipse.egit.github.core.service.RepositoryService; 
import org.eclipse.egit.github.core.client.GitHubClient; 
import org.eclipse.egit.github.core.Commit; 
import org.eclipse.egit.github.core.CommitUser; 
import org.eclipse.egit.github.core.Tree; 
import org.eclipse.egit.github.core.service.UserService; 
import org.eclipse.egit.github.core.User; 

//import org.junit.Ignore; 


//https://stackoverflow.com/questions/46215024/adding-file-to-github-using-java-client-org-eclipse-egit-github-core
	
public class TESTGITHUBAPI 
{
	protected GitHubClient client = null; 

	public void createclientuser(String username, String password)
	{
		client = new GitHubClient();
		client.setCredentials(username, password);
	}
						
	public void createclienttoken(String strToken )
	{
		//OAuth2 token authentication
		client = new GitHubClient();
		client.setOAuth2Token(strToken);
	}

	@Test 
	public void fetchCurrentUserUserPWD() throws Exception 
	{ 
		client = null;
		createclientuser("corryco", "Uaz9401CC");
		assertNotNull("Test requires user", client.getUser()); 

		UserService service = new UserService(client); 
		User user = service.getUser(); 
		assertNotNull(user); 
		assertEquals(client.getUser(), user.getLogin()); 
		assertNotNull(user.getGravatarId()); 
		assertNotNull(user.getAvatarUrl()); 
		assertNotNull(user.getCreatedAt()); 
		assertNotNull(user.getPlan()); 
	 } 
	 
	@Test 
	public void fetchCurrentUserToken() throws Exception 
	{ 
		client = null;
		createclienttoken("09224f92fb573e6eb6e3f878710b235c9030115d");
		UserService service = new UserService(client); 
		User user = service.getUser(); 
		assertNotNull(user); 
		assertNotNull(user.getGravatarId()); 
		assertNotNull(user.getAvatarUrl()); 
		assertNotNull(user.getCreatedAt()); 
		assertNotNull(user.getPlan()); 
	 } 

	@Test 
	 public void createRepository() throws IOException 
	{ 
		 createclientuser("corryco", "Uaz9401CC");
		 assertNotNull("Client user is required", client.getUser()); 

		 RepositoryService service = new RepositoryService(client); 
		 Repository repository = new Repository(); 
		 repository.setOwner(new User().setLogin(client.getUser())); 
		 repository.setName("TEMP-REPRO-" + System.currentTimeMillis()); 
		 repository.setPrivate(true); 
		 
		 Repository created = service.createRepository(repository); 
		 assertNotNull(created); 
		 assertNotSame(repository, created); 
		 assertTrue(created.isPrivate()); 
		 assertEquals(repository.getName(), created.getName()); 
	 } 
	
	 @Test 
	 public void fetchRepositories() throws IOException 
	 { 
		 createclientuser("corryco", "Uaz9401CC");
		 assertNotNull("Client user is required", client.getUser()); 

		 RepositoryService service = new RepositoryService(client); 
		 List<Repository> repos = service.getRepositories("defunkt"); 
		 assertNotNull(repos); 
		 assertFalse(repos.isEmpty()); 

		 for (Repository repo : repos) 
		 { 
			 assertNotNull(repo); 
			 assertNotNull(repo.getName()); 
			 assertNotNull(repo.getOwner()); 
			 assertNotNull(repo.getUrl()); 
			 assertNotNull(repo.getCreatedAt()); 
			 assertTrue(repo.getSize() >= 0); 
			 assertTrue(repo.getForks() >= 0); 
			 assertTrue(repo.getOpenIssues() >= 0); 
			 assertTrue(repo.getWatchers() >= 0); 
		} 
	} 
	
	 @Test 
	 public void fetchForks() throws IOException 
	 { 
		 createclientuser("corryco", "Uaz9401CC");
		 assertNotNull("Client user is required", client.getUser()); 
		 
		 RepositoryService service = new RepositoryService(client); 
		 List<Repository> repos = service.getForks(new RepositoryId("defunkt", "resque")); 
		 assertNotNull(repos); 
		 assertFalse(repos.isEmpty()); 
		 
		 for (Repository repo : repos) 
		 { 
			 assertNotNull(repo); 
			 assertTrue(repo.isFork()); 
		 } 
	 }
	 
	 @Test 
	 public void commitdefaultState() 
	 { 
		 Commit commit = new Commit(); 
		 assertNull(commit.getAuthor()); 
		 assertNull(commit.getCommitter()); 
		 assertNull(commit.getMessage()); 
		 assertNull(commit.getParents()); 
		 assertNull(commit.getSha()); 
		 assertNull(commit.getTree()); 
		 assertNull(commit.getUrl()); 
		 assertEquals(0, commit.getCommentCount()); 
	 } 

	 @Test 
	 public void commitupdateFields()
	 { 
		 Commit commit = new Commit(); 
		 CommitUser author = new CommitUser().setName("Art Thor"); 
		 assertEquals(author, commit.setAuthor(author).getAuthor()); 
		 CommitUser committer = new CommitUser().setName("Comb Mitter"); 
		 assertEquals(committer, commit.setCommitter(committer).getCommitter()); 
		 assertEquals("commit message", commit.setMessage("commit message").getMessage()); 
		 assertEquals(new ArrayList<Commit>(), commit.setParents(new ArrayList<Commit>()).getParents()); 
		 assertEquals("abcdef", commit.setSha("abcdef").getSha()); 
		
		 Tree tree = new Tree(); 
		 tree.setSha("12345"); 
		 assertEquals(tree, commit.setTree(tree).getTree()); 
		 assertEquals("url", commit.setUrl("url").getUrl()); 
		 assertEquals(32, commit.setCommentCount(32).getCommentCount()); 
	 }
}
