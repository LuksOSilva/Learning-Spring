package br.com.luksosilva.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseObjectList(List<O> originList, Class<D> destination) {

        List<D> destinationObjects = new ArrayList<>();

        for (Object o : originList) {
            destinationObjects.add(mapper.map(o, destination));
        }

        return destinationObjects;
    }
}
