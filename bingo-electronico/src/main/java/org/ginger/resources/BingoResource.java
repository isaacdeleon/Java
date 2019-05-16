package org.ginger.resources;

import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.ginger.controllers.BingoController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Web resource for all the bingo operations.
 *
 * @author Isaac Laurrabaquio &lt;
 * @version 1.0.0
 * @since 1.0.0
 */
@Path("/bingo")
@Api(value="/Operacion Bingo", description = "descripcion del servicio")
public class BingoResource {

    /**
     * Logger Class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(BingoResource.class);

    /**
     * Bingo controller.
     */
    private BingoController bingoController;

    /**
     * Constructor for BingoResource.
     */
    public BingoResource(final BingoController bingoController) {
        this.bingoController = bingoController;
    }

    /**
     * Resource to get Generated Number.
     *
     * @return Response.
     */
    @GET
    @Path("/getNextRandom")
    @Produces(MediaType.TEXT_PLAIN)
    @Timed
    @ApiOperation(value = "Operacion para obtener siguiente numero")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="Obtuvo successfully"),
            @ApiResponse(code=500, message="Error occurred in server"),
    })
    public Response getNextRandom() {
        try {
            //return Response.ok().entity(1).build();
            return Response.ok().entity(bingoController.getRandomNumber()).build();
        } catch (final Exception ex) {
            LOGGER.error("Error Getting RandomNumber:{}" , ex);
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }

    /**
     * Resource Test.
     *
     * @return Response.
     */
    @GET
    @Path("/getCurrentNumbers")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @ApiOperation(value = "Operacion para obtener los numeros generados en el juego")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="Obtuvo successfully"),
            @ApiResponse(code=500, message="Error occurred in server"),
    })
    public Response getCurrentNumbers() {
        try {
            return Response.ok().entity(bingoController.getGeneratedNumbers()).build();
        } catch (final Exception ex) {
            LOGGER.error("Error Getting RandomNumber:{}" , ex);
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }

    /**
     * Resource Test.
     *
     * @return Response.
     */
    @GET
    @Path("/resetGame")
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @ApiOperation(value = "Operacion para reiniciar el juego")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="Se reinicio successfully"),
            @ApiResponse(code=500, message="Error occurred in server"),
    })
    public Response resetGame() {
        if (bingoController.generateNewGame() == 0) {
            return Response.ok().entity("El juego se ha reiniciado").build();
        } else {
            return Response.serverError().entity("Ha ocurrido un Error").build();
        }
    }
}
