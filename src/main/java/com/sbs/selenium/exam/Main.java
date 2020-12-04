package com.sbs.selenium.exam;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sbs.selenium.exam.dto.DcArticle;
import com.sbs.selenium.exam.dto.NatePannArticle;
import com.sbs.selenium.exam.dto.NaverNewsArticle;

public class Main {
	public static void main(String[] args) {
		printNatePannTop100Articles();
		
	}
	
	private static void printNatePannTop100Articles() {
		int no = 0;
		Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver", path.toString());

		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");

		ChromeDriver driver = new ChromeDriver(options);

		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(0));
		driver.get("https://pann.nate.com/talk/ranking?rankingType=total&page=1");

//		Util.sleep(2000);

		List<WebElement> elements = driver.findElements(By.cssSelector(".post_wrap li"));
		System.out.println(elements.size());
		for (WebElement element : elements) {
			int id = no+1;
			String title = element.findElement(By.cssSelector("dl>dt>a")).getText().trim();
			String counts = element.findElement(By.cssSelector("dl>.info>.count")).getText().trim();
			String rcms = element.findElement(By.cssSelector("dl>.info>.rcm")).getText().trim();
			String url = element.findElement(By.cssSelector("dl>dt>a")).getAttribute("href").trim();
			if(counts.contains(",")){
				counts = counts.replaceAll(",","");
			}
			if(rcms.contains(",")){
				rcms = rcms.replaceAll(",","");
			}
			int count = Integer.parseInt(counts.split(" ")[1]);
			int rcm = Integer.parseInt(rcms.split(" ")[1]);
			
//			System.out.println(url);
			NatePannArticle article = new NatePannArticle(title, count, rcm, url, id);

//			List<NatePannArticle> articles = new ArrayList<>();
//			articles.add(article);
			driver.findElement(By.linkText(article.getUrl()));
//			System.out.println(article.getUrl());
//			articles.get(id);
			
//			System.out.println(articles.get(1).getUrl());
//			for(int i = 0 ; i < 50; i++) {
//				article.getUrl(i);
//			}
//			System.out.printf("%d / %s / %s / %s / %d / %d\n", id, title, writer, regDate, count, rcm);
			no = id;
		}
		driver.quit();
	}

	private static void printNaverNewsLatestArticles() {
		Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver", path.toString());

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");

		ChromeDriver driver = new ChromeDriver(options);

		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(0));
		driver.get("https://news.naver.com/main/list.nhn?mode=LSD&mid=sec&sid1=001");

//		Util.sleep(2000);

		List<WebElement> elements = driver.findElements(By.cssSelector(".type06_headline li"));

		for (WebElement element : elements) {
			String title = element.findElement(By.cssSelector("dl dt:nth-child(2) > a")).getText().trim();
			String writer = element.findElement(By.cssSelector(".writing")).getText().trim();
			String body = element.findElement(By.cssSelector(".lede")).getText().trim();
			String img = "";

			try {
				img = element.findElement(By.cssSelector(".photo")).getAttribute("src");
			} catch (NoSuchElementException e) {
				// TODO: handle exception
			}

			NaverNewsArticle article = new NaverNewsArticle(title, writer, body, img);
			System.out.println("--------------------------");
			System.out.printf("제목: %s\n신문사: %s\n내용: %s\n이미지URL: %s\n", title, writer, body, img);
			System.out.println("--------------------------");
		}
	}

	private static void printDcTreeGallyLatestArticles() {
		Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver", path.toString());

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");

		ChromeDriver driver = new ChromeDriver(options);

		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(0));
		driver.get("https://gall.dcinside.com/board/lists/?id=tree");

//		Util.sleep(2000);

		List<WebElement> elements = driver.findElements(By.cssSelector(".gall_list .us-post"));

		for (WebElement element : elements) {
			String title = element.findElements(By.cssSelector(".gall_tit > a")).get(0).getText().trim();
			int id = Integer.parseInt(element.findElements(By.cssSelector(".gall_num")).get(0).getText().trim());
			String writer = element.findElements(By.cssSelector(".nickname")).get(0).getText().trim();
			String regDate = element.findElements(By.cssSelector(".gall_date")).get(0).getAttribute("title").trim();
			int count = Integer.parseInt(element.findElements(By.cssSelector(".gall_count")).get(0).getText().trim());
			int rcm = Integer.parseInt(element.findElements(By.cssSelector(".gall_recommend")).get(0).getText().trim());

			DcArticle article = new DcArticle(id, title, writer, regDate, count, rcm);
			System.out.printf("%d / %s / %s / %s / %d / %d\n", id, title, writer, regDate, count, rcm);
		}
	}
}
