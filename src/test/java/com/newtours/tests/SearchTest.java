package com.newtours.tests;

import com.base.driver.BaseTest;
import com.searchduck.pages.SearchPage;

import org.testng.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class SearchTest extends BaseTest {

    @Test
    @Parameters({"keyWord"})
    public void search(String keyWord) {
        SearchPage search = new SearchPage(driver);
        search.goTo();
        search.doSearch(keyWord);
        search.clickVideos();
        int count = search.countVideos();
        System.out.println(count);

        Assert.assertTrue(count > 0);

    }

}
