package org.ginger;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Dropwizard configuration for Bingo Electronico.
 *
 * @author Isaac Laurrabaquio &lt;
 * @version 1.0.0
 * @since 1.0.0
 */
public class BingoElectronicoConfiguration extends Configuration {

    /**
     * Swagger configuration.
     */
    private SwaggerBundleConfiguration swaggerConfig;

    /**
     * alphabet of the bingo game.
     */
    @NotEmpty
    private String alphabet;

    /**
     * Getter for swagger configuration.
     *
     * @return the swaggerConfig.
     */
    @JsonProperty("swagger")
    public SwaggerBundleConfiguration getSwaggerConfig() {
        return swaggerConfig;
    }

    /**
     * Setter for swagger configuration.
     *
     * @param swaggerConfig the swaggerConfig to set.
     */
    public void setSwaggerConfig(final SwaggerBundleConfiguration swaggerConfig) {
        this.swaggerConfig = swaggerConfig;
    }

    /**
     * alphabet getter.
     * @return String class.
     * @see java.lang.String
     */
    @JsonProperty("alphabet")
    public String getAlphabet() {
        return alphabet;
    }

    /**
     * alphabet setter.
     */
    public void setAlphabet(final String alphabet) {
        this.alphabet = alphabet;
    }
}
