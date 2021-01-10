package Modules;

import java.util.ArrayList;
import java.util.List;

import Modules.Route;

public interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);
}
