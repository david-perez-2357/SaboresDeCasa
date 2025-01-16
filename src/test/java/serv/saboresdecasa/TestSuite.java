package serv.saboresdecasa;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import serv.saboresdecasa.unitTests.PlatoServiceUnitTest;
import serv.saboresdecasa.unitTests.TipoPlatoServiceUnitTest;

@Suite
@SelectClasses({
        AddAllData.class,
        serv.saboresdecasa.unitTests.PedidoServiceUnitTest.class,
        serv.saboresdecasa.integrationTests.PedidoServiceIntegrationTest.class,
        PlatoServiceUnitTest.class,
        serv.saboresdecasa.integrationTests.PlatoServiceIntegrationTest.class,
        TipoPlatoServiceUnitTest.class,
        serv.saboresdecasa.integrationTests.TipoPlatoIntegrationTest.class,
        serv.saboresdecasa.unitTests.ClienteServiceUnitTest.class,
        serv.saboresdecasa.integrationTests.ClienteServiceIntegrationTest.class,
})
public class TestSuite {
    // Vacío
}
