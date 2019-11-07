import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before; 

import java.io.IOException; 
import java.util.List; 
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
import org.eclipse.egit.github.core.service.WatcherService; 


public class TESTGITHUBAPI 
{
	protected GitHubClient client = null; 

	@Before
	public void createclientuser()
	{
		client = new GitHubClient();
		client.setCredentials("corryco", "Uaz9401CC");
	}

	@Test 
	public void fetchCurrentUserUserPWD() throws Exception 
	{ 
		client = null;
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
		GitHubClient tokclient = new GitHubClient();
		tokclient.setOAuth2Token("09224f92fb573e6eb6e3f878710b235c9030115d");

		UserService service = new UserService(tokclient); 
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
		 assertNotNull("Client user is required", client.getUser()); 

		 RepositoryService service = new RepositoryService(client); 
		 List<Repository> repos = service.getRepositories("corryco"); 
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
	  //Test fetching followers 
	 public void fetchFollowers() throws Exception 
	 { 
		assertNotNull("Test requires user", client.getUser()); 

		UserService service = new UserService(client); 
		List<User> users = service.getFollowers(); 
		assertNotNull(users); 
		for (User user : users) 
		{ 
			assertNotNull(user.getId()); 
			assertNotNull(user.getLogin()); 
		} 
	 } 
	 
	 @Test 
	  //Test fetching followed users 
	 public void fetchFollowing() throws Exception 
	 { 
		assertNotNull("Test requires user", client.getUser()); 
	  
		assertNotNull("Test requires user", client.getUser()); 
		UserService service = new UserService(client); 
		List<User> users = service.getFollowing(); 
		assertNotNull(users); 
		for (User user : users) 
		{ 
			assertNotNull(user.getId()); 
			assertNotNull(user.getLogin()); 
		} 
	 } 
	 
	 @Test 
	 //Test getting watchers of a repository 
	 public void getWatchers() throws Exception 
	 { 
		 assertNotNull("Client user is required", client.getUser()); 

		 WatcherService service = new WatcherService(client); 
		 List<User> watchers = service.getWatchers(new RepositoryId("defunkt", "dotjs")); 
		 assertNotNull(watchers); 
		 for (User watcher : watchers) 
		 { 
			 assertNotNull(watcher); 
			 assertNotNull(watcher.getLogin()); 
		 } 
	 } 
	 
	 @Test 
	  //Test getting repositories watched by a user 
	 public void getWatched() throws Exception 
	 { 
		 assertNotNull("Client user is required", client.getUser()); 

		 WatcherService service = new WatcherService(client); 
		  List<Repository> watched = service.getWatched("corryco"); 
		  assertNotNull(watched); 
		  for (Repository repo : watched) 
		  { 
			   assertNotNull(repo); 
			   assertNotNull(repo.getName()); 
			   assertNotNull(repo.getOwner()); 
		  } 
	 } 
	 
	 @Test 
	 public void fetchForks() throws IOException 
	 { 
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
		 CommitUser author = new CommitUser().setName("Conor Corry"); 
		 assertEquals(author, commit.setAuthor(author).getAuthor()); 
		 CommitUser committer = new CommitUser().setName("Joe Blogs"); 
		 assertEquals(committer, commit.setCommitter(committer).getCommitter()); 
		 assertEquals("Another commit message", commit.setMessage("Another commit message").getMessage()); 
		 assertEquals(new ArrayList<Commit>(), commit.setParents(new ArrayList<Commit>()).getParents()); 
		 assertEquals("TestText", commit.setSha("TestText").getSha()); 
		
		 Tree tree = new Tree(); 
		 tree.setSha("NewTestText"); 
		 assertEquals(tree, commit.setTree(tree).getTree()); 
		 assertEquals("url", commit.setUrl("url").getUrl()); 
		 assertEquals(32, commit.setCommentCount(32).getCommentCount()); 
	 }
}
