package com.bipbup.intagration;


import com.bipbup.scrapper.IntegrationEnvironment;
import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InitMigrationTest extends IntegrationEnvironment {
    private static final String SQL =
            "SELECT column_name FROM information_schema.columns WHERE table_name = ? AND table_schema = 'link_tracker';";
    private static final List<String> LINK_COLUMNS = List.of("id", "resource", "updated_at");
    private static final List<String> CHAT_COLUMNS = List.of("id");
    private static final List<String> ASSOCIATION_COLUMNS = List.of("link_id", "chat_id");

    @Test
    @DisplayName("Check creating t_link")
    @SneakyThrows
    void tableLinkCreateTest() {
        @Cleanup
        Connection connection = POSTGRES.createConnection("");
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setString(1, "t_link");
        var result = statement.executeQuery();
        List<String> values = new ArrayList<>();

        while (result.next()) {
            values.add(result.getString("column_name"));
        }

        assertThat(values).containsExactlyElementsOf(LINK_COLUMNS);
    }

    @Test
    @DisplayName("Check creating t_chat")
    @SneakyThrows
    void tableChatCreateTest() {
        @Cleanup
        Connection connection = POSTGRES.createConnection("");
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setString(1, "t_chat");
        var result = statement.executeQuery();
        List<String> values = new ArrayList<>();

        while (result.next()) {
            values.add(result.getString("column_name"));
        }

        assertThat(values).containsExactlyElementsOf(CHAT_COLUMNS);
    }

    @Test
    @DisplayName("Check creating t_chat_link")
    @SneakyThrows
    void tableAssociationCreateTest() {
        @Cleanup
        Connection connection = POSTGRES.createConnection("");
        PreparedStatement statement = connection.prepareStatement(SQL);
        statement.setString(1, "t_chat_link");
        var result = statement.executeQuery();
        List<String> values = new ArrayList<>();
        while (result.next()) {
            values.add(result.getString("column_name"));
        }

        assertThat(values).containsExactlyElementsOf(ASSOCIATION_COLUMNS);
    }
}
