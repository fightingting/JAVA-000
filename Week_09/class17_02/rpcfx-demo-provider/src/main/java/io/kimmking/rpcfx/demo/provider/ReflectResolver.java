package io.kimmking.rpcfx.demo.provider;

import io.kimmking.rpcfx.api.RpcfxResolver;
import org.reflections.Reflections;

import java.util.Set;

/**
 * @author wangtingting
 * @date 2021-02-26 17:41
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
public class ReflectResolver implements RpcfxResolver {
    @Override
    public Object resolve(String serviceClass) {


        try {
            Reflections reflections = new Reflections(getClass().getPackage().getName());

            Set<Class> implClass = reflections.getSubTypesOf((Class)Class.forName(serviceClass));
            if(implClass.isEmpty()){
                return null;
            }
            Class klass = implClass.stream().findFirst().get();
            return klass.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
