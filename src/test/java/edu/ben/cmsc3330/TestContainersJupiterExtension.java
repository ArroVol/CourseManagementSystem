package edu.ben.cmsc3330;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.wait.strategy.Wait;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

@Slf4j
public class TestContainersJupiterExtension implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {

    private boolean started = false;
    static Network testNetwork = Network.newNetwork();

    static MySQLContainer mysql = new MySQLContainer<>()
            .withExposedPorts(3306)
            .waitingFor(Wait.forListeningPort())
            .withNetworkAliases("mysql")
            .withNetwork(testNetwork);


    /**
     * Callback that is invoked once <em>before</em> all tests in the current
     * container.
     *
     * @param context the current extension context; never {@code null}
     */
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        if(!started){
            started = true;
            log.info("starting containers");
            mysql.start();
            context.getRoot().getStore(GLOBAL).put("unique name", this);
        }
    }

    /**
     * Close underlying resources.
     *
     * @throws Throwable any throwable will be caught and rethrown
     */
    @Override
    public void close() throws Throwable {
    // after all tests logic goes here
    }
}
