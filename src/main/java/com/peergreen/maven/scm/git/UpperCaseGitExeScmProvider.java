package com.peergreen.maven.scm.git;

import org.apache.maven.scm.provider.ScmProvider;
import org.apache.maven.scm.provider.git.gitexe.GitExeScmProvider;
import org.codehaus.plexus.component.annotations.Component;

/**
 * User: guillaume
 * Date: 02/07/13
 * Time: 17:33
 */
@Component(role = ScmProvider.class, hint = "git")
public class UpperCaseGitExeScmProvider extends GitExeScmProvider {
    @Override
    public String sanitizeTagName(final String tag) {
        String sanitized = super.sanitizeTagName(tag);
        sanitized = sanitized.replace('-', '_')
                             .replace('.', '_');
        return sanitized.toUpperCase();
    }
}
