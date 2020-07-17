package com.d.cvandportfolioapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.d.cvandportfolioapp.cv.CVFragment;
import com.d.cvandportfolioapp.home.HomeFragment;
import com.d.cvandportfolioapp.portfolio.PortfolioFragment;
import com.d.cvandportfolioapp.sidemenu.Callback;
import com.d.cvandportfolioapp.sidemenu.MenuAdapter;
import com.d.cvandportfolioapp.sidemenu.MenuItem;
import com.d.cvandportfolioapp.sidemenu.MenuUtil;
import com.d.cvandportfolioapp.team.TeamFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {

    RecyclerView rvMenu;
    List<MenuItem> menuItems;
    MenuAdapter adapter;
    int selectedMenuPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        // set side menu
        setUpSideMenu();

        // set the default fragment when activity launch
        setHomeFragment();
    }

    private void setUpSideMenu() {
        rvMenu = findViewById(R.id.rv_side_menu);
        menuItems = MenuUtil.getMenuList();
        adapter = new MenuAdapter(menuItems, this);
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        rvMenu.setAdapter(adapter);
    }

    void setPortfolioFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PortfolioFragment()).commit();
    }

    void setTeamFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TeamFragment()).commit();
    }

    void setCVFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CVFragment()).commit();
    }

    void setHomeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }

    @Override
    public void onSideMenuItemClick(int i) {
        switch (menuItems.get(i).getCode()) {
            case MenuUtil.HOME_FRAGMENT_CODE:
                setHomeFragment();
                break;
            case MenuUtil.CV_FRAGMENT_CODE:
                setCVFragment();
                break;
            case MenuUtil.TEAM_FRAGMENT_CODE:
                setTeamFragment();
                break;
            case MenuUtil.PORTFOLIO_FRAGMENT_CODE:
                setPortfolioFragment();
                break;
            default:
                setHomeFragment();
        }

        // highligh the selected menu item
        menuItems.get(selectedMenuPos).setSelected(false);
        menuItems.get(i).setSelected(true);
        selectedMenuPos = i;
        adapter.notifyDataSetChanged();
    }

}
