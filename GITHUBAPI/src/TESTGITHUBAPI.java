import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException; 
import java.util.List; 
import java.util.Map; 
import java.util.Map.Entry; 
import java.util.ArrayList; 

import org.eclipse.egit.github.core.Repository; 
import org.eclipse.egit.github.core.RepositoryId; 
import org.eclipse.egit.github.core.User; 
import org.eclipse.egit.github.core.service.RepositoryService; 
import org.eclipse.egit.github.core.client.GitHubClient; 
import org.eclipse.egit.github.core.Commit; 
import org.eclipse.egit.github.core.CommitUser; 
import org.eclipse.egit.github.core.Tree; 

import org.junit.Ignore; 

///http://www.javased.com/index.php?source_dir=egit-github/org.eclipse.egit.github.core.tests/src/org/eclipse/egit/github/core/tests/live/LiveTest.java

public class TESTGITHUBAPI 
{

	GitHubClient client; 
	
	@Test
	public void test() 
	{
		fail("Not yet implemented");
	}

	@Test 
	 @Ignore 
	 public void createRepository() throws IOException 
	{ 
	  assertNotNull("Client user is required", client.getUser()); 
	  RepositoryService service = new RepositoryService(client); 
	  Repository repository = new Repository(); 
	  repository.setOwner(new User().setLogin(client.getUser())); 
	  repository.setName("test-create-" + System.currentTimeMillis()); 
	  repository.setPrivate(true); 
	  Repository created = service.createRepository(repository); 
	  assertNotNull(created); 
	  assertNotSame(repository, created); 
	  assertTrue(created.isPrivate()); 
	  assertEquals(repository.getOwner(), created.getOwner()); 
	  assertEquals(repository.getName(), created.getName()); 
	 } 
	
	@Test 
	 public void fetchRepositories() throws IOException { 
	  RepositoryService service = new RepositoryService(client); 
	  List<Repository> repos = service.getRepositories("defunkt"); 
	  assertNotNull(repos); 
	  assertFalse(repos.isEmpty()); 
	  for (Repository repo : repos) { 
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
	public void getLanguages() throws IOException 
	{
		  RepositoryService service=new RepositoryService(client);
		  Map<String,Long> languages=service.getLanguages(new RepositoryId("defunkt","resque"));
		  assertNotNull(languages);
		  assertFalse(languages.isEmpty());
		  for ( Entry<String, Long> language : languages.entrySet()) {
		    assertNotNull(language.getKey());
		    assertFalse(language.getKey().length() == 0);
		    assertTrue(language.getValue() > 0);
		  }
	}
	
	/**
	  * Test forking a repository 
	  * 
	  * @throws Exception 
	  */ 
	 @Test 
	 @Ignore 
	 public void forkRepository() throws Exception { 
	  assertNotNull("Client user is required", client.getUser()); 
	  RepositoryService service = new RepositoryService(client); 
	  service.forkRepository(new RepositoryId(client.getUser(), "resque")); 
	 } 
	 
	 /**
	  * Test fetching forks of a repository 
	  * 
	  * @throws IOException 
	  */ 
	 @Test 
	 public void fetchForks() throws IOException 
	 { 
		  RepositoryService service = new RepositoryService(client); 
		  List<Repository> repos = service.getForks(new RepositoryId("defunkt", 
		    "resque")); 
		  assertNotNull(repos); 
		  assertFalse(repos.isEmpty()); 
		  for (Repository repo : repos) 
		  { 
		   assertNotNull(repo); 
		   assertTrue(repo.isFork()); 
		  } 
	 } 
	 /**
	  * Test default state of commit 
	  */ 
	 @Test 
	 public void defaultState() 
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
	 
	 /**
	  * Test updating commit fields 
	  */ 
	 @Test 
	 public void updateFields() 
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
