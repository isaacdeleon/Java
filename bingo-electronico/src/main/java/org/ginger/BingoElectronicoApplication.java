package org.ginger;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.ginger.controllers.BingoController;
import org.ginger.cors.CORSResponseFilter;
import org.ginger.resources.BingoResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Dropwizard application for Bingo Electronico.
 * Dropwizard application for Bingo Electronico.
 *
 * @author Isaac Laurrabaquio &lt;
 * @version 1.0.0
 * @since 1.0.0
 */
public class BingoElectronicoApplication extends Application<BingoElectronicoConfiguration> {

    /**
     * Logger Class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BingoElectronicoApplication.class);

    /**
     * Starts the microservice container.
     *
     * @param args Command line arguments.
     * @throws Exception in case of errors while starting the container.
     */
    public static void main(final String... args) throws Exception {
        LOGGER.info("Starting Bingo Electronico.");
        new BingoElectronicoApplication().run(args);
    }

    /**
     * Initializes the application.
     *
     * @param bootstrap The bootstrap object with the Digital Virgo Consumer configuration.
     * @see io.dropwizard.Application#initialize(io.dropwizard.setup.Bootstrap)
     */
    @Override
    public void initialize(final Bootstrap<BingoElectronicoConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                                                 new EnvironmentVariableSubstitutor(false)));
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new SwaggerBundle<BingoElectronicoConfiguration>() {
            /**
             * Retrieves the swagger configuration.
             *
             * @param config The Swagger configurtion object.
             * @see io.federecio.dropwizard.swagger.SwaggerBundle#getSwaggerBundleConfiguration(io.dropwizard.Configuration)
             */
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(final BingoElectronicoConfiguration config) {
                return config.getSwaggerConfig();
            }
        });
    }

    /**
     * Runs the Bingo electronico application.
     *
     * @param bingoElectronicoConfiguration The application configuration.
     * @param environment The application environment.
     * @see io.dropwizard.Application#run(io.dropwizard.Configuration, io.dropwizard.setup.Environment)
     */
    @Override
    public void run(final BingoElectronicoConfiguration bingoElectronicoConfiguration,
                    final Environment environment) throws Exception {
        final CORSResponseFilter corsFilter = new CORSResponseFilter();
        BingoController bingoController = new BingoController(bingoElectronicoConfiguration.getAlphabet());
        BingoResource bingoResource = new BingoResource(bingoController);
        environment.jersey().register(corsFilter);
        environment.jersey().register(bingoResource);
    }
}
