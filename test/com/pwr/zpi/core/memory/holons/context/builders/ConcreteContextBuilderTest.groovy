package holons.context.builders

import com.pwr.zpi.core.memory.episodic.BaseProfile
import com.pwr.zpi.core.memory.holons.context.builders.ConcreteContextBuilder
import com.pwr.zpi.core.memory.holons.context.builders.ContextBuilder
import com.pwr.zpi.core.memory.holons.context.selectors.LatestGroupSelector
import com.pwr.zpi.core.memory.holons.context.selectors.LatestSelector
import com.pwr.zpi.core.memory.semantic.IndividualModel
import com.pwr.zpi.core.memory.semantic.ObjectType
import com.pwr.zpi.core.memory.semantic.identifiers.QRCode
import com.pwr.zpi.language.*

/**
 * Created by Grzesiek on 2017-06-02.
 */
class ConcreteContextBuilderTest extends GroovyTestCase {

    BaseProfile bp1, bp2, bp3, bp4, bp5, bp6, bp7, bp8, bp9, bp6_2, bp4_2, bp9_2
    int t


    def model1, model2
    def tr1, tr2, tr3, tr4, tr5, tr6, tr7
     def formula
    def namedGroundingSets

    void setUp() {

        tr1 = new Trait("Red")
        tr2 = new Trait("White")
        tr3 = new Trait("Blinking")
        tr4 = new Trait("Green")
        tr5 = new Trait("Striped")
        tr6 = new Trait("patterned")
        tr7 = new Trait("Blue")
        def oType1 = new ObjectType("04", [tr1, tr2, tr3, tr4, tr5, tr6])

        model1 = new IndividualModel(new QRCode("0123"), oType1)
        model2 = new IndividualModel(new QRCode("0124"), oType1)



        t = 0;
        bp1 = new BaseProfile([[(tr6): [model1] as Set<IndividualModel>, (tr7): [model1] as Set<IndividualModel>,
                                 (tr1): [model1] as Set<IndividualModel>, (tr5): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                                [(tr4): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               new HashMap<Trait, Set<IndividualModel>>()

        ] as List, t++)
        bp2 = new BaseProfile([[(tr2): [model1] as Set<IndividualModel>, (tr3): [model1] as Set<IndividualModel>,
                                (tr1): [model1] as Set<IndividualModel>, (tr6): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               [(tr4): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               new HashMap<Trait, Set<IndividualModel>>()
        ] as List, t++)
        bp3 = new BaseProfile([[(tr2): [model1] as Set<IndividualModel>, (tr1): [model1] as Set<IndividualModel>,
                                (tr4): [model1] as Set<IndividualModel>, (tr6): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               [(tr5): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               new HashMap<Trait, Set<IndividualModel>>()

        ] as List, t++)
        bp4 = new BaseProfile([[(tr1): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               [(tr2): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               [(tr3): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>
        ] as List, t++)
        bp4_2 = new BaseProfile([[(tr2): [model2] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               [(tr3): [model2] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               [(tr1): [model2] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>
        ] as List, t)
        bp5 = new BaseProfile([[(tr2): [model1] as Set<IndividualModel>, (tr3): [model1] as Set<IndividualModel>,
                                   (tr1): [model1] as Set<IndividualModel>, (tr6): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                                  [(tr4): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                                  [(tr5): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>
        ] as List, t++)
        bp6 = new BaseProfile([[(tr2): [model1] as Set<IndividualModel>, (tr3): [model1] as Set<IndividualModel>,
                                (tr1): [model1] as Set<IndividualModel>, (tr6): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               [(tr4): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               [(tr5): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>
        ] as List, t++)
        bp6_2 = new BaseProfile([[(tr2): [model2] as Set<IndividualModel>, (tr3): [model2] as Set<IndividualModel>,
                                  (tr1): [model2] as Set<IndividualModel>, (tr6): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               [(tr1): [model2] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               [(tr3): [model2] as Set<IndividualModel>, (tr2): [model2] as Set<IndividualModel>]
        ] as List, t)
        bp7 = new BaseProfile([[(tr2): [model1] as Set<IndividualModel>, (tr3): [model1] as Set<IndividualModel>,
                                (tr1): [model1] as Set<IndividualModel>, (tr6): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               [(tr4): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               [(tr5): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>
        ] as List, t++)
        bp8 = new BaseProfile([[(tr2): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               [(tr1): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               [(tr3): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>
        ] as List, t++)
        bp9 = new BaseProfile([[(tr3): [model1] as Set<IndividualModel>, (tr5): [model1] as Set<IndividualModel>,
                                (tr4): [model2] as Set<IndividualModel>, (tr1): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               new HashMap<Trait, Set<IndividualModel>>(),
                               [(tr1): [model1] as Set<IndividualModel>, (tr2): [model1] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>
        ] as List, t++)
        bp9_2 = new BaseProfile([[(tr2): [model2] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>,
                               new HashMap<Trait, Set<IndividualModel>>(),
                               [(tr1): [model2] as Set<IndividualModel>, (tr3): [model2] as Set<IndividualModel>] as Map<Trait, Set<IndividualModel>>
        ] as List, t++)

        formula = new ComplexFormula(model1, [tr1, tr2],
                [State.IS_NOT, State.IS], LogicOperator.AND)

        namedGroundingSets = Grounder.getGroundingSets(formula, [bp1, bp2, bp3, bp4, bp5, bp6, bp7, bp8] as Set<BaseProfile>)
    }

    void testBuild() {
        ContextBuilder builder = new ConcreteContextBuilder()
        def testContext = builder.build(model1, [bp9] as Set<BaseProfile>)
        assertEquals([tr3, tr5, tr1] as List<Trait>, testContext.getObservedTraits())
        assertEquals([] as List<Trait>, testContext.getNotObservedTraits())

        testContext = builder.build(model1, [bp9, bp8,bp2] as Set<BaseProfile>)
        assertEquals([] as List<Trait>, testContext.getObservedTraits())
        assertEquals([] as List<Trait>, testContext.getNotObservedTraits())

        testContext = builder.build(model1, [bp7, bp5, bp6] as Set<BaseProfile>)
        assertEquals([tr2, tr3, tr1, tr6] as List<Trait>, testContext.getObservedTraits())
        assertEquals([tr4] as List<Trait>, testContext.getNotObservedTraits())

        testContext = builder.build(model1, [bp7, bp5, bp6, bp6_2] as Set<BaseProfile>)
        assertEquals([tr6] as List<Trait>, testContext.getObservedTraits())
        assertEquals([] as List<Trait>, testContext.getNotObservedTraits())

        testContext = builder.build(model1, [bp7, bp1, bp2, bp3] as Set<BaseProfile>)
        assertEquals([tr1, tr6] as List<Trait>, testContext.getObservedTraits())
        assertEquals([] as List<Trait>, testContext.getNotObservedTraits())
    }

    void testCompareWithSelector() {
        ContextBuilder builder = new ConcreteContextBuilder()
        def testContext = builder.build(model1, [bp8] as Set<BaseProfile>)
        def testContext2 = builder.build(model1, new LatestSelector().select(namedGroundingSets))
        def testContext3 = builder.build(model1, new LatestGroupSelector(1).select(namedGroundingSets))

        assertEquals(testContext, testContext2)
        assertEquals(testContext, testContext3)
        assertEquals([tr2] as List<Trait>, testContext3.getObservedTraits())
        assertEquals([tr1] as List<Trait>, testContext3.getNotObservedTraits())
    }
}
