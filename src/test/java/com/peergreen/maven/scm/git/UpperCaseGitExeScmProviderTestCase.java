package com.peergreen.maven.scm.git;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * User: guillaume
 * Date: 03/07/13
 * Time: 09:41
 */
public class UpperCaseGitExeScmProviderTestCase {
    @Test
    public void testSanitizeTagName() throws Exception {
        UpperCaseGitExeScmProvider provider = new UpperCaseGitExeScmProvider();

        assertEquals(provider.sanitizeTagName("peergreen-deployment-1.0.0"),
                     "PEERGREEN_DEPLOYMENT_1_0_0");

        // With qualifiers
        assertEquals(provider.sanitizeTagName("peergreen-deployment-1.0.0-M2"),
                     "PEERGREEN_DEPLOYMENT_1_0_0_M2");
    }

    @Test
    public void testTagIsUpperCase() throws Exception {
        UpperCaseGitExeScmProvider provider = new UpperCaseGitExeScmProvider();

        assertEquals(provider.sanitizeTagName("sOmeWorD"), "SOMEWORD");
    }

    @Test
    public void testDotIsTransformedInUnderscore() throws Exception {
        UpperCaseGitExeScmProvider provider = new UpperCaseGitExeScmProvider();

        assertEquals(provider.sanitizeTagName("."), "_");
    }

    @Test
    public void testDashIsTransformedInUnderscore() throws Exception {
        UpperCaseGitExeScmProvider provider = new UpperCaseGitExeScmProvider();

        assertEquals(provider.sanitizeTagName("-"), "_");
    }
}
