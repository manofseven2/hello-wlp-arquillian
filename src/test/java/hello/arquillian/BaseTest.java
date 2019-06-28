package hello.arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
@Ignore
public class BaseTest {
    @Deployment
    public static WebArchive createDeployment() {
        MavenDependencyResolver resolver = DependencyResolvers.use(
                MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
        File[] files = resolver.includeDependenciesFromPom("pom.xml").resolveAsFiles();

        return ShrinkWrap
                .create(WebArchive.class)
                .addPackages(true, Filters.exclude(".*Test.*"),
                        Logger.class.getPackage(),
                        ResteasyWebTarget.class.getPackage())
                .addPackages(true, "hello.arquillian")
                .addAsManifestResource(EmptyAsset.INSTANCE, "arquillian.xml")
                .addAsLibraries(files)
                .addAsWebInfResource("beans.xml", "beans.xml");

    }
}
